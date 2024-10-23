package com.example.laboratorio5;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container_1, FragmentList.newInstance(
                            "Catedral de Arequipa",
                            "La Catedral de Arequipa fue construida con ignimbrita " +
                                    "(piedra de origen volcánico) y bóvedas de ladrillo. Es el " +
                                    "santuario principal de la ciudad, ocupando todo el lado norte " +
                                    "de la Plaza de Armas. Construida totalmente en sillar, exhibe " +
                                    "un estilo neorrenacentista con cierta influencia gótica. Su fachada " +
                                    "está constituida por setenta columnas con capiteles corintios, tres " +
                                    "portadas y dos grandes arcos laterales. Está rematada por dos altas " +
                                    "torres renacentistas y estilizadas.",
                            R.drawable.catedral_image,
                            R.id.fragment_container_1
                    ))
                    .replace(R.id.fragment_container_2, FragmentList.newInstance(
                            "Claustro de la Compañía",
                            "El Claustro de la Compañía se erige como un ejemplo notable de " +
                                    "la arquitectura arequipeña, construido en sillar, la característica " +
                                    "piedra blanca de la región. Su diseño combina elementos del estilo " +
                                    "barroco con detalles de influencia neogótica, creando un espacio de " +
                                    "gran armonía visual. Este claustro destaca por sus elegantes arcos de " +
                                    "medio punto, que rodean un patio central adornado con jardines y fuentes," +
                                    " proporcionando un ambiente sereno. Las columnas, con capiteles corintios" +
                                    ", y las intrincadas tallas en la piedra añaden un toque de sofisticación.",
                            R.drawable.claustro_image,
                            R.id.fragment_container_2
                    ))
                    .commit();
        }
    }
}

