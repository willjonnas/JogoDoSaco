public class Ouvintes {


    private int id;
    private String nome;
    private String distrito;
    private int idade;
    private int idranking;
    private int numeroTentativas;
    private int numeroVitorias;

    public Ouvintes() {
        id = 0;
        nome = "";
        distrito = "";
        idade = 0;
        idranking = 0;
        numeroTentativas = 0;
        numeroVitorias = 0;
    }

    public Ouvintes(int id, String nome,String distrito, int idade,int idranking, int numeroTentativas, int numeroVitorias) {
        this.id = id;
        this.nome = nome;
        this.distrito = distrito;
        this.idade = idade;
        this.idranking = idranking;
        this.numeroTentativas = numeroTentativas;
        this.numeroVitorias = numeroVitorias;
    }
    public Ouvintes(int id, String nome,int idade,String distrito, int numeroTentativas, int numeroVitorias) {
        this.id = id;
        this.nome = nome;
        this.distrito = distrito;
        this.idade = idade;
        this.numeroTentativas = numeroTentativas;
        this.numeroVitorias = numeroVitorias;
    }

    public Ouvintes(int id, String nome, int idade, String distrito) {
        this.id = id;
        this.nome = nome;
        this.distrito = distrito;
        this.idade = idade;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public int getIdranking() {
        return idranking;
    }

    public void setIdranking(int idranking) {
        this.idranking = idranking;
    }

    public int getNumeroTentativas() {
        return numeroTentativas;
    }

    public void setNumeroTentativas(int numeroTentativas) {
        this.numeroTentativas = numeroTentativas;
    }

    public int getNumeroVitorias() {
        return numeroVitorias;
    }

    public void setNumeroVitorias(int numeroVitorias) {
        this.numeroVitorias = numeroVitorias;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return ("Ouvinte: " + id + "\tNome: " + nome + " idade " + idade + "  Distrito " + distrito );
    }


}