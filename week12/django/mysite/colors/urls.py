from django.conf.urls import url

from . import views

urlpatterns = [
    url(r'^$', views.index, name='index'),
    url(r'^list', views.get_colors_list, name='list'),
    url(r'^add', views.add_color, name='add'),
    url(r'^get', views.get_color, name='get'),
]
