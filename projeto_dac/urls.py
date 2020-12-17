"""web_project URL Configuration

The `urlpatterns` list routes URLs to views. For more information please see:
    https://docs.djangoproject.com/en/3.1/topics/http/urls/
Examples:
Function views
    1. Add an import:  from my_app import views
    2. Add a URL to urlpatterns:  path('', views.home, name='home')
Class-based views
    1. Add an import:  from other_app.views import Home
    2. Add a URL to urlpatterns:  path('', Home.as_view(), name='home')
Including another URLconf
    1. Import the include() function: from django.urls import include, path
    2. Add a URL to urlpatterns:  path('blog/', include('blog.urls'))
"""
from django.contrib import admin
from django.urls import path, include
from projeto_dac import views
from .views import lista_eventos,novo_evento,atualiza_evento,deleta_evento,lista_edicao,nova_edicao,atualiza_edicao,deleta_edicao


urlpatterns = [
    path('list_evento/',lista_eventos, name="lista_evento"),
    path('novo/',novo_evento, name="novo_evento"),
    path('atualiza/<int:id>/',atualiza_evento, name="atualiza_evento"),
    path('deleta/<int:id>/',deleta_evento, name="deleta_evento"),
    path('lista_edicao/', lista_edicao, name="lista_edicao"),
    path('nova_edicao/', nova_edicao, name="nova_edicao"),
    path('atualiza_edicao/<int:id>/',atualiza_edicao, name="atualiza_edicao"),
    path('deleta_edicao/<int:id>/',deleta_edicao, name="deleta_edicao"),
    
]