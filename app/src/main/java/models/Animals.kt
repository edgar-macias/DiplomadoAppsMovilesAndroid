package models

import mx.emp.primerproyecto.R

fun animalList():List<Animal>{
    return listOf(
        Animal(id=1,name="León",img = R.drawable.ic_img_placeholder),
        Animal(id=2,name="Perro",img = R.drawable.ic_img_placeholder),
        Animal(id=3,name="Gato",img = R.drawable.ic_img_placeholder),
        Animal(id=4,name="Pingüino",img = R.drawable.ic_img_placeholder),
        Animal(id=5,name="Delfín",img = R.drawable.ic_img_placeholder),
        Animal(id=6,name="Tigre",img = R.drawable.ic_img_placeholder),
        Animal(id=7,name="Zorro",img = R.drawable.ic_img_placeholder),
        Animal(id=8,name="Colibrí",img = R.drawable.ic_img_placeholder),
        Animal(id=9,name="Canario",img = R.drawable.ic_img_placeholder),
        Animal(id=10,name="Elefante",img = R.drawable.ic_img_placeholder),
    )
}