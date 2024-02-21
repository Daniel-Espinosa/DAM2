# -*- coding: utf-8 -*-
{
    'name': "desarrollador",

    'summary': """
        Modulo para gestionar Desarrolladores y los Juegos que tienen""",

    'description': """
        El Desarrollador tendrá como atributos:
            •	Nombre Empresa
            •	CIF
            •	Dirección
            •	Teléfono
            •	Email

        Juego se relacionará con Desarrollador de Uno a Uno.

        Los Juegos tendrán como atributos
            •	Nombre Juego
            •	PEGI
            •	Fecha salida
            •	Precio
            •	Genero
    """,

    'author': "Daniel Espinosa Garcia & Cafe Con Palito",
    'website': "https://github.com/CafeConPalito/",

    # Categories can be used to filter modules in modules listing
    # Check https://github.com/odoo/odoo/blob/16.0/odoo/addons/base/data/ir_module_category_data.xml
    # for the full list
    'category': 'Inventory',
    'version': '1.0.1',

    # any module necessary for this one to work correctly
    'depends': ['base'],

    # always loaded
    'data': [
        # 'security/ir.model.access.csv',
        'views/views.xml',
        'views/templates.xml',
    ],
    # only loaded in demonstration mode
    # 'demo': [
    #     'demo/demo.xml',
    # ],
}
