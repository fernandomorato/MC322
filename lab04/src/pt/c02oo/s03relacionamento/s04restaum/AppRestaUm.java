package pt.c02oo.s03relacionamento.s04restaum;

public class AppRestaUm {

   public static void main(String[] args) {
      AppRestaUm.executaJogo(null, null);
   }
   
   public static void executaJogo(String arquivoEntrada, String arquivoSaida) {
      Toolkit tk = Toolkit.start(arquivoEntrada, arquivoSaida);
      
      String commands[] = tk.retrieveCommands();
      
      System.out.println("=== Entrada");
      for (int l = 0; l < commands.length; l++)
         System.out.println(commands[l]);
      
      System.out.println("=== Primeira Saída");
      char board[][] = {
         {' ', ' ', 'P', 'P', 'P', ' ', ' '},
         {' ', ' ', 'P', 'P', 'P', ' ', ' '},
         {'P', 'P', 'P', 'P', 'P', 'P', 'P'},
         {'P', 'P', 'P', '-', 'P', 'P', 'P'},
         {'P', 'P', 'P', 'P', 'P', 'P', 'P'},
         {' ', ' ', 'P', 'P', 'P', ' ', ' '},
         {' ', ' ', 'P', 'P', 'P', ' ', ' '}
      };
            
      tk.writeBoard("Tabuleiro inicial", board);

      Tabuleiro tab = new Tabuleiro(board);      
      for (int i = 0; i < commands.length; i++) {
    	  int linhaInicial = commands[i].charAt(1) - '1';
    	  int colunaInicial = commands[i].charAt(0) - 'a';
    	  int linhaFinal = commands[i].charAt(4) - '1';
    	  int colunaFinal = commands[i].charAt(3) - 'a';
    	  tab.move(linhaInicial, colunaInicial, linhaFinal, colunaFinal);
    	  tk.writeBoard("Movimento " + commands[i].substring(0, 2) + " -> " + commands[i].substring(3, 5), tab.apresenta());
      }
      
      tk.stop();
   }

}
