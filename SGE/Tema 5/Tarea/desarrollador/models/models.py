# -*- coding: utf-8 -*-

from odoo import models, fields, api

class desarrollador(models.Model):
    _name = 'modulo.desarrollador'
    _description = 'modulo.desarrollador'

    nombre = fields.Char(
        string='Nombre',
        store=True,
        readonly=False,
        required=True,
        translate=False)
    cif = fields.Char(
        string='CIF',
        store=True,
        readonly=False,
        required=True,
        translate=False)
    direccion = fields.Char(
        string='Direccion',
        store=True,
        readonly=False,
        required=True,
        translate=False)
    telefono = fields.Integer(
        string='Telefono',
        store=True,
        readonly=False,
        required=True,
        translate=False)
    email = fields.Char(
        string='Email',
        store=True,
        readonly=False,
        required=True,
        translate=False)

class juego(models.Model):
    _name = 'modulo.juego'
    _description = 'modulo.juego'

    nombre = fields.Char(
        string='Nombre',
        store=True,
        readonly=False,
        required=True,
        translate=False)
    pegi = fields.Selection(
        selection=[('1','PEGI-3'),('2','PEGI-7'),('3','PEGI-12'),('4','PEGI-16'),('5','PEGI-18')],
        string='PEGI',
        store=True,
        readonly=False,
        required=True,
        translate=False
        )
    fecha = fields.Date(
        string='Fecha de Salida', 
        default=fields.Datetime.now,
        store=True,
        readonly=False,
        required=True,
        translate=False
        )
    precio = fields.Float(
        string='Precio',
        store=True,
        readonly=False,
        required=True,
        translate=False)
    genero = fields.Selection(
        selection=[('1','Accion'),('2','Aventura'),('3','Puzzle'),('4','Rol'),('5','Carrera'),('6','Lucha'),('7','Estrategia'),('8','Simulacion')],
        string='GENERO',
        store=True,
        readonly=False,
        required=True,
        translate=False
        )
    desarrollador = fields.Many2one(
        'modulo.desarrollador',
        string='Desarrolador',
        store=True,
        readonly=False,
        required=True,
        translate=False
        )

    # @api.depends('value')
    # def _value_pc(self):
    #     for record in self:
    #         record.value2 = float(record.value) / 100
