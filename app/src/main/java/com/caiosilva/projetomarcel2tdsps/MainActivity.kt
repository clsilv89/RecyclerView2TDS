package com.caiosilva.projetomarcel2tdsps

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.caiosilva.projetomarcel2tdsps.databinding.ActivityMainBinding

class MainActivity : ComponentActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        val lista = listComic()
        val adapter: ComicsAdapter = ComicsAdapter()
        adapter.submitList(lista)
        adapter.onclickListener = {
            println(it.title)
        }

        binding.recyclewViewComics.adapter = adapter
        binding.recyclewViewComics.layoutManager = LinearLayoutManager(this)
    }

    private fun listComic(): List<ComicBookData> {
        return listOf(
            ComicBookData(
                1,
                "Homem Aranha",
                "Adolescente é picado por aranha radioativa e prefere sair no soco com bandidos a pagar a conta do hospital",
                12
            ),
            ComicBookData(
                2,
                "Homem de Ferro",
                "Bilionária cria arma de destruição em massa individual para não pagar resgate do próprio sequestro",
                23
            ),
            ComicBookData(
                3,
                "Thor",
                "Deus nórdico resolve namorar humana para não ter que lidar com o próprio pai",
                34
            ),
            ComicBookData(
                4,
                "Capitão América",
                "Soldado toma bomba para socar nazista mais forte",
                45
            ),
            ComicBookData(
                5,
                "Hawkeye",
                "Homem comum acredita fazer sentido sair na mão com deuses e alienigenas armado apenas com arco e 12 flechas",
                56
            ),
            ComicBookData(
                6,
                "Viuva Negra",
                "Scalett Johansson de roupa apertada",
                67
            ),
            ComicBookData(
                7,
                "Thor 3",
                "Chris Hemsworth sem roupa e com muitos (MUITOS) musculos",
                78
            ),
            ComicBookData(
                8,
                "Vingadores",
                "Grande homem roxo cansado de lidar com pessoas, resolve esvaziar o universo",
                89
            ),
        )
    }
}