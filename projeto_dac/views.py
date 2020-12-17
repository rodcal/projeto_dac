from django.shortcuts import render,redirect, get_object_or_404
from django.http import HttpResponse
from projeto_dac import views
from .models import Evento , Edicao
from .forms import EventoForm, EdicaoForm


#Eventos
def lista_eventos(request):
    termo_busca = request.GET.get('pesquisa', None)
    busca_data_inicio = request.GET.get('pesquisa_data_inicio')
    if termo_busca:
        eventos = Evento.objects.all()
        eventos = Evento.objects.filter(nome__contains=termo_busca) 
    else:
        eventos = Evento.objects.all()
    return render(request, 'eventos.html', {'eventos' : eventos})

def novo_evento(request):
    form = EventoForm(request.POST or None)
    if form.is_valid():
        form.save()
        return redirect('lista_evento')
    return render(request, 'novo_evento.html',{'form': form})
def atualiza_evento(request, id):
    evento = get_object_or_404(Evento, pk=id)
    form = EventoForm(request.POST or None, instance=evento)
    if form.is_valid():
        form.save()
        return redirect('lista_evento')
    return render(request,'novo_evento.html',{'form': form})
 
def deleta_evento(request, id):
    evento = get_object_or_404(Evento, pk=id)
    form = EventoForm(request.POST or None, instance=evento)
    if request.method == 'POST':
        evento.delete()
        return redirect('lista_evento')
    return render(request,'confirma_exclusao.html',{'form': form})

#Edicao
def lista_edicao(request):
    termo_busca_cidade = request.GET.get('pesquisa_cidade',None)
    busca_por_data_inicio = request.GET.get('pesquisa_data_inicio',None)
    busca_por_data_fim = request.GET.get('pesquisa_data_fim',None)
    if termo_busca_cidade and (busca_por_data_inicio or busca_por_data_fim):
        edicaos = Edicao.objects.all()
        edicaos = Edicao.objects.filter(cidade__contains=termo_busca_cidade) & Edicao.objects.filter(data_inicio__gt=busca_por_data_inicio,data_fim__lte=busca_por_data_fim)
    elif termo_busca_cidade:
        edicaos = Edicao.objects.filter(cidade__contains=termo_busca_cidade)
    elif busca_por_data_inicio and busca_por_data_fim:
        edicaos = Edicao.objects.filter(data_inicio__gt=busca_por_data_inicio,data_fim__lte=busca_por_data_fim)
    elif busca_por_data_inicio:
        edicaos = Edicao.objects.filter(data_inicio__gt=busca_por_data_inicio)
    else:
        edicaos = Edicao.objects.all()
    return render(request, 'edicaos.html', {'edicaos': edicaos})

def nova_edicao(request):
    form_edicao = EdicaoForm(request.POST or None)
    if form_edicao.is_valid():
        form_edicao.save()
        return redirect('lista_edicao')
    return render(request, 'nova_edicao.html',{'form_edicao': form_edicao})
def atualiza_edicao(request, id):
    edicao = get_object_or_404(Edicao, pk=id)
    form_edicao = EdicaoForm(request.POST or None, instance=edicao)
    if form_edicao.is_valid():
        form_edicao.save()
        return redirect('lista_edicao')
    return render(request,'nova_edicao.html',{'form_edicao': form_edicao})
def deleta_edicao(request, id):
    edicao = get_object_or_404(Edicao, pk=id)
    form_edicao = EdicaoForm(request.POST or None, instance=edicao)
    if request.method == 'POST':
        edicao.delete()
        return redirect('lista_edicao')
    return render(request,'confirma_exclusao_edicao.html',{'form_edicao': form_edicao})  