package br.com.alura.ceep.ui.databinding

import androidx.databinding.ObservableField
import androidx.databinding.ObservableBoolean
import br.com.alura.ceep.model.Nota

class NotaData(
    var nota: Nota = Nota(),
    val titulo: ObservableField<String> = ObservableField(nota.titulo),
    val descricao: ObservableField<String> = ObservableField(nota.descricao),
    val favorita: ObservableBoolean = ObservableBoolean(nota.favorita),
    val imagemUrl: ObservableField<String> = ObservableField(nota.imagemUrl)
) {
    fun atualiza(notaEncontrada: Nota) {
        nota = notaEncontrada
        titulo.set(notaEncontrada.titulo)
        favorita.set(notaEncontrada.favorita)
        imagemUrl.set(notaEncontrada.imagemUrl)
        descricao.set(notaEncontrada.descricao)
    }

    fun paraNota(): Nota? {
        return this.nota.copy(
            titulo = titulo.get() ?: return null,
            descricao = descricao.get() ?: return null,
            favorita = favorita.get(),
            imagemUrl = imagemUrl.get() ?: return null
        )
    }
}
