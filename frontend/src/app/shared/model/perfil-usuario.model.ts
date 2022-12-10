import {Livro} from "./livro.model";
import {Trofeu} from "./trofeu.model";

export interface PerfilUsuario {
  id: number;

  nome: string;

  login: string;

  funcao: string;

  pontos: number;

  trofeus: Trofeu[];

  livros: Livro[];
}
