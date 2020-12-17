from django.db import models

# Create your models here.
class Evento(models.Model):
    nome = models.CharField(max_length=100)
    sigla = models.CharField(max_length=10)
    area_concentracao = models.CharField(max_length=100)
    instituicao_org = models.CharField(max_length=100)
    
    def __str__(self):
        return self.nome

class Edicao(models.Model):
    num_edicao = models.IntegerField()
    ano = models.IntegerField()
    data_inicio = models.DateField(null=True, blank=True)
    data_fim = models.DateField(null=True, blank=True)
    cidade = models.CharField(max_length=100)
    pais = models.CharField(max_length=100)
    evento = models.ForeignKey(Evento, default = None, on_delete = models.CASCADE)
    
    def __str__(self):
        return str(self.evento) + ' ' + str(self.num_edicao) + 'º Edição ' + self.cidade + ' ' + self.pais
