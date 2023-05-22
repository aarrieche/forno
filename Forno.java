public class Forno {
    private final int volume;
    private final int tensao;
    private final int potencia;
    private final int largura;
    private final int altura;
    private final int profundidade;
    private int temperatura;
    private boolean ligado;
    private int timer;

    public Forno(int volume, int tensao, int potencia, int largura, int altura, int profundidade) {
        this.volume = volume;
        this.tensao = tensao;
        this.potencia = potencia;
        this.largura = largura;
        this.altura = altura;
        this.profundidade = profundidade;
        this.temperatura = 0;
        this.ligado = false;
        this.timer = 0;
    }

    public int getVolume() {
        return volume;
    }

    public int getTensao() {
        return tensao;
    }

    public int getPotencia() {
        return potencia;
    }

    public int getLargura() {
        return largura;
    }

    public int getAltura() {
        return altura;
    }

    public int getProfundidade() {
        return profundidade;
    }

    public int getTemperatura() {
        return temperatura;
    }

    public boolean isLigado() {
        return ligado;
    }

    public int getTimer() {
        return timer;
    }

    public void setTimer(int minutos) {
        if (minutos >= 1 && minutos <= 120) {
            this.timer = minutos;
        } else {
            System.out.println("O timer deve estar entre 1 e 120 minutos.");
        }
    }

    public void aumentarTemperatura() {
        if (!ligado) {
            ligado = true;
        }

        if (temperatura < 300) {
            if (temperatura >= 200 && temperatura < 250) {
                temperatura = 250;
            } else {
                temperatura += 50;
            }
        }
    }

    public void diminuirTemperatura() {
        if (temperatura >= 50) {
            if (temperatura > 200 && temperatura <= 250) {
                temperatura = 200;
            } else {
                temperatura -= 50;
            }
        } else {
            desligar();
        }
    }

    public void desligar() {
        temperatura = 0;
        ligado = false;
    }

    public void tick() {
        if (timer > 0) {
            timer--;

            if (timer == 0) {
                desligar();
            }
        }
    }
}
