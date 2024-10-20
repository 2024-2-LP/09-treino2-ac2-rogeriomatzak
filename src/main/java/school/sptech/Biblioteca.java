package school.sptech;

import school.sptech.exception.ArgumentoInvalidoException;
import school.sptech.exception.LivroNaoEncontradoException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private List<Livro> livros;
    private String nome ;

    public Biblioteca() {
        this.livros = new ArrayList<>();
    }

    public void adicionarLivro(Livro livro) {
        if(livro == null || livro.getTitulo() == null || livro.getTitulo().isBlank()||  livro.getAutor() == null || livro.getAutor().isBlank() || livro.getDataPublicacao() == null){
            throw new ArgumentoInvalidoException("Livro inválido.");
        }
        this.livros.add(livro);
    }

    public void removerLivroPorTitulo(String titulo) {
        if (titulo == null || titulo.trim().isEmpty()) {
            throw new ArgumentoInvalidoException("Título inválido.");
        }

        boolean livroRemovido = false;
        for (int i = 0; i < livros.size(); i++) {
            if (livros.get(i).getTitulo().equalsIgnoreCase(titulo)) {
                livros.remove(i);
                livroRemovido = true;
                break;
            }
        }

        if (!livroRemovido) {
            throw new LivroNaoEncontradoException("Livro não encontrado.");
        }
    }

    public Livro buscarLivroPorTitulo(String titulo) {
        if (titulo == null || titulo.trim().isEmpty()) {
            throw new ArgumentoInvalidoException("Título inválido.");
        }

        for (Livro livro : livros) {
            if (livro.getTitulo().equalsIgnoreCase(titulo)) {
                return livro;
            }
        }
        throw new LivroNaoEncontradoException("Livro não encontrado.");
    }

    public Integer contarLivros() {
        return livros.size();
    }

    public List<Livro> obterLivrosAteAno(Integer ano) {
        List<Livro> resultado = new ArrayList<>();
        for (Livro livro : livros) {
            if (livro.getDataPublicacao().getYear() <= ano) {
                resultado.add(livro);
            }
        }
        return resultado;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}