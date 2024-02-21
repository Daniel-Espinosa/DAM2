# -*- coding: utf-8 -*-
# from odoo import http


# class Desarrollador(http.Controller):
#     @http.route('/desarrollador/desarrollador', auth='public')
#     def index(self, **kw):
#         return "Hello, world"

#     @http.route('/desarrollador/desarrollador/objects', auth='public')
#     def list(self, **kw):
#         return http.request.render('desarrollador.listing', {
#             'root': '/desarrollador/desarrollador',
#             'objects': http.request.env['desarrollador.desarrollador'].search([]),
#         })

#     @http.route('/desarrollador/desarrollador/objects/<model("desarrollador.desarrollador"):obj>', auth='public')
#     def object(self, obj, **kw):
#         return http.request.render('desarrollador.object', {
#             'object': obj
#         })
