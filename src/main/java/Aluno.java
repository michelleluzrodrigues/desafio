/**
 * Classe representa o Aluno
 *
 * @author Michelle Luz Rodrigues
 * @data 18/01/2021
 */
public class Aluno {
    /***************************************/
    /*            Atributos de classe      */
    /***************************************/
    private Integer matricula;
    private String aluno;
    private Integer falta;
    private Float p1;
    private Float p2;
    private Float p3;
    private String situacao;
    private Float notaAprovacao;
    private static final Integer HORAS_AULAS = 60;

    /**
     * @param matricula numero da matricula do aluno
     * @param aluno     nome do aluno
     * @param falta     numero de faltas do aluno
     * @param p1        nota da primeira prova do aluno
     * @param p2        nota da segunda prova do aluno
     * @param p3        nota da terceira prova do aluno
     */
    public Aluno(Integer matricula, String aluno, Integer falta, Float p1, Float p2, Float p3) {
        this.matricula = matricula;
        this.aluno = aluno;
        this.falta = falta;
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;

        verificaSituacao();

    }

    @Override
    public String toString() {
        return "Aluno{" +
                "matricula=" + matricula +
                ", aluno='" + aluno + '\'' +
                ", falta=" + falta +
                ", p1=" + p1 +
                ", p2=" + p2 +
                ", p3=" + p3 +
                ", situacao='" + situacao + '\'' +
                ", notaAprovacao=" + notaAprovacao +
                '}';
    }

    /**
     * Metodo verifica a situação do aluno
     * Seguindo as regras
     * |----------------------------------------|
     * |presença < 25%| Reprovado por Falta     |
     * |media < 5     | Reprovado por Nota      |
     * |5 <= media < 7| Exame Final             |
     * |media >= 7    | Aprovado                |
     * |----------------------------------------|
     */
    private void verificaSituacao() {
        // Verifica se o numero de faltas ultrapasse 25% das horas aulas
        if (this.falta >= HORAS_AULAS * 0.25) {
            this.situacao = "Reprovado por Falta";
            this.notaAprovacao = 0F;
        } else {

            Float media = (this.p1 + this.p2 + this.p3) / 3;
            // Verifica a media do aluno
            if (media < 50) {
                this.situacao = "Reprovado por Falta";
                this.notaAprovacao = 0F;
            } else if (media < 70) {
                this.notaAprovacao = 100 - media;
                this.situacao = "Exame Final";

            } else {
                this.situacao = "Aprovado";
                this.notaAprovacao = 0F;
            }
        }
    }

    /***************************************/
    /*            geters and seters       */

    /***************************************/
    public Integer getMatricula() {
        return matricula;

    }

    public void setMatricula(Integer matricula) {
        this.matricula = matricula;
    }

    public String getAluno() {
        return aluno;
    }

    public void setAluno(String aluno) {
        this.aluno = aluno;
    }

    public Integer getFalta() {
        return falta;
    }

    public void setFalta(Integer falta) {
        this.falta = falta;
    }

    public Float getP1() {
        return p1;
    }

    public void setP1(Float p1) {
        this.p1 = p1;
    }

    public Float getP2() {
        return p2;
    }

    public void setP2(Float p2) {
        this.p2 = p2;
    }

    public Float getP3() {
        return p3;
    }

    public void setP3(Float p3) {
        this.p3 = p3;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public Integer getNotaAprovacao() {
        return Math.round(notaAprovacao);
    }

    public void setNotaAprovacao(Float notaAprovacao) {
        this.notaAprovacao = notaAprovacao;
    }
}
