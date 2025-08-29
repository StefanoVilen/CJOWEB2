public class Data {
    private int dia;
    private int mes;
    private int ano;

    // Construtor com validação
    public Data(int dia, int mes, int ano) {
        setDia(dia);
        setMes(mes);
        setAno(ano);
    }

    // Getters e Setters com validação
    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        if (dia >= 1 && dia <= 30) {
            this.dia = dia;
        } else {
            System.out.println("Dia inválido!");
        }
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        if (mes >= 1 && mes <= 12) {
            this.mes = mes;
        } else {
            System.out.println("Mês inválido!");
        }
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        if (ano >= 1900) {
            this.ano = ano;
        } else {
            System.out.println("Ano inválido!");
        }
    }

    // Retorna a data formatada
    public String getDataFormatada() {
        return String.format("%02d/%02d/%04d", dia, mes, ano);
    }
}
