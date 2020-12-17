from django.forms import ModelForm
from .models import Evento
from .models import Edicao

class EventoForm(ModelForm):
    class Meta:
        model = Evento
        fields = ['nome','sigla','area_concentracao','instituicao_org']
class EdicaoForm(ModelForm):
    class Meta:
        model = Edicao
        fields = ['num_edicao','ano','data_inicio','data_fim','cidade','pais','evento']