package br.com.example.appacessibilidade


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.example.appacessibilidade.model.VagaResponse
import br.com.example.appacessibilidade.ui.VagaAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * A simple [Fragment] subclass.
 */
class VagaFragment : Fragment() {

    lateinit var vagaAdapter: VagaAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_vaga, container, false)
        vagas()
    }

    fun vagas(){
        br.com.example.appacessibilidade.Service.retrofit.vagas()
            .enqueue(object : Callback<VagaResponse>{
                override fun onFailure(call: Call<VagaResponse>, t: Throwable) {
                    Log.d("Erro", t.toString())
                }

                override fun onResponse(call: Call<VagaResponse>, response: Response<VagaResponse>) {
                    Log.d("Sucesso", response.body().toString())
                        response.body()?.let { vaga ->
                            vagaAdapter.vagas
                        }
                }

            })
    }

}
