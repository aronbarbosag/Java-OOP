package controller;


/**
 * Classe base para todos os controladores do sistema.
 * Define o padrão de hierarquia, onde cada controlador (exceto o principal)
 * possui uma referência ao seu "pai".
 */
public abstract class CtrlAbstrato {

    /**
     * Representa o controlador que disparou a
     * execução do controlador em questão
     */
    final private CtrlAbstrato ctrlPai;

    public CtrlAbstrato(CtrlAbstrato pai) {
        this.ctrlPai = pai;
    }

    /**
     * Retorna quem é o controlador pai que disparou a execução
     * do caso de uso em questão.
     */
    public CtrlAbstrato getCtrlPai() {
        return this.ctrlPai;
    }

    /**
     * Método que define o que é para ser feito ao final do caso de uso.
     * Geralmente, fecha a janela e notifica o controlador pai.
     */
    public abstract void encerrar();

    /**
     * Método que define qual é o bem tangível produzido
     * ao final do caso de uso (ex: o objeto que foi criado).
     */
    public abstract Object getBemTangivel();
}
