package br.com.example.appacessibilidade.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.example.appacessibilidade.R
import br.com.example.appacessibilidade.model.VagaResponse
import kotlinx.android.synthetic.main.fragment_vaga.view.*

class VagaAdapter (var vagas: ArrayList<VagaResponse>): RecyclerView.Adapter<VagaAdapter.VagaAdapterHolder>(){

    fun updateVagas(newVagas: List<VagaResponse>){
        vagas.clear()
        vagas.addAll(newVagas)
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        VagaAdapterHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.fragment_vaga, parent, false)
    )


    override fun getItemCount() = vagas.size

    override fun onBindViewHolder(holder: VagaAdapterHolder, position: Int) {
        val vaga = vagas[position]

        holder.bind(vaga)
    }
    class VagaAdapterHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        fun bind(vaga: VagaResponse){
            itemView.txtNomeVaga.text = vaga.titulo
            itemView.txtTipoVaga.text = vaga.descricao
            itemView.txtNumVagas.text = vaga.quantidade_vagas.toString()

        }

    }
}