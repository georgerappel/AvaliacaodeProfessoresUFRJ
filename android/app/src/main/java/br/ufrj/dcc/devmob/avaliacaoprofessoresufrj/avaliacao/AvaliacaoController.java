package br.ufrj.dcc.devmob.avaliacaoprofessoresufrj.avaliacao;

import java.util.List;

import br.ufrj.dcc.devmob.avaliacaoprofessoresufrj.service.HttpService;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by devmob on 06/04/17.
 */

public class AvaliacaoController {

    public static String salvarAvaliacao(Avaliacao avaliacao)
            throws java.io.IOException{

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(HttpService.baseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        HttpService service = retrofit.create(HttpService.class);
        return service.salvarAvaliacao(avaliacao.getDreAluno(), avaliacao.getMatProf(),
                    avaliacao.getComentario(), avaliacao.getNota(), avaliacao.getTags()).execute().body();

    }

    public static List<Avaliacao> listarAvaliacoesPorAluno(String dreAluno)
            throws java.io.IOException{

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(HttpService.baseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        HttpService service = retrofit.create(HttpService.class);
        return service.listarAvaliacoes(dreAluno).execute().body();

    }

    public static List<Avaliacao> listarAvaliacoesPorDocente(String matProf)
            throws java.io.IOException{

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(HttpService.baseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        HttpService service = retrofit.create(HttpService.class);
        return service.listarAvaliacoesDocente(matProf).execute().body();

    }
}