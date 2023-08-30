package br.senai.sp.jandira.game.model;

public class Scenario {

    public String Scenario(int scenarioOption){

        String scenario = "Senai Jandira";

        switch (scenarioOption){
            case 1:
                scenario = "Arabia Junto com o Ney";
                break;

            case 2:
                scenario = "Grecia";
                break;

            case 3:
                scenario = "Los Angeles";
                break;

            case 4:
                scenario = "Tóquio";
                break;

            case 5:
                scenario = "Pequim";
                break;

            case 6:
                scenario = "Las Vegas";
                break;

        }

        return scenario;

    }


}
