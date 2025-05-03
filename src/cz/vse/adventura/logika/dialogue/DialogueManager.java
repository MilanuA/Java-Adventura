package cz.vse.adventura.logika.dialogue;

import cz.vse.adventura.logika.Postava;

public class DialogueManager
{
    private static DialogueManager instance;

    private boolean isDialogueAktivni;
    private int radek;
    private Postava mluviciPostava;

    private DialogueManager() {
        isDialogueAktivni = false;
    }

    public static synchronized DialogueManager getInstance() {
        if (instance == null)
        {
            instance = new DialogueManager();
        }

        return instance;
    }

    public void zacitDialog(Postava postava){
        isDialogueAktivni = true;
        mluviciPostava = postava;
        radek = -1;
    }

    public boolean getIsDialogueAktivni() {
        return isDialogueAktivni;
    }

    public String dalsiRadek() {
        radek++;
        String dialog = mluviciPostava.getNextDialog(radek);

        if (dialog == null) {
            ZastavitDialog();
            return "Rozhovor s postavou skončil.";
        }
    
        return dialog;
    }

    private void ZastavitDialog(){
        isDialogueAktivni = false;
    }
}
