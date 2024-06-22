import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

public class FlowerInfoGUI extends JFrame {
    private JTextField txtEspecieFlor, txtBiomaFlor, txtCorFlor;
    private JLabel lblImagemFlor, lblFraseFlor;
    private JButton btnGerarFraseFlor, btnTrocarParaPolvo;
    private JButton btnFazerFotossintese, btnCrescer, btnFlorescer;

    private OctopusInfoGUI octopusInfoGUI;
    private CelularInfoGUI celularInfoGUI;

    public FlowerInfoGUI() {
        setTitle("Informações de Flores");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panelFlor = new JPanel();
        panelFlor.setLayout(new GridLayout(7, 2));

        panelFlor.add(new JLabel("Espécie:"));
        txtEspecieFlor = new JTextField();
        panelFlor.add(txtEspecieFlor);

        panelFlor.add(new JLabel("Bioma:"));
        txtBiomaFlor = new JTextField();
        panelFlor.add(txtBiomaFlor);

        panelFlor.add(new JLabel("Cor:"));
        txtCorFlor = new JTextField();
        panelFlor.add(txtCorFlor);

        btnGerarFraseFlor = new JButton("Gerar Frase");
        btnGerarFraseFlor.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                gerarFraseFlor();
            }
        });
        panelFlor.add(btnGerarFraseFlor);

        lblFraseFlor = new JLabel();
        panelFlor.add(lblFraseFlor);

        lblImagemFlor = new JLabel();
        panelFlor.add(lblImagemFlor); // Adiciona o label da imagem ao painel

        // Função para exibir a imagem quando o botão "Gerar Frase" é clicado
        lblImagemFlor.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                gerarFraseFlor();
            }
        });

        // Exibe a imagem quando a interface é iniciada
        exibirImagem("default_flor.jpg");

        btnFazerFotossintese = new JButton("Fazer Fotossíntese");
        btnFazerFotossintese.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                lblFraseFlor.setText("A Flor " + txtEspecieFlor.getText() + " está fazendo fotossíntese");
            }
        });
        panelFlor.add(btnFazerFotossintese);

        btnCrescer = new JButton("Crescer");
        btnCrescer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                lblFraseFlor.setText("A Flor " + txtCorFlor.getText() + " está crescendo");
            }
        });
        panelFlor.add(btnCrescer);

        btnFlorescer = new JButton("Florescer");
        btnFlorescer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                lblFraseFlor.setText("A Flor no bioma " + txtBiomaFlor.getText() + " está florescendo");
            }
        });
        panelFlor.add(btnFlorescer);

        btnTrocarParaPolvo = new JButton("Ver Polvos");
        btnTrocarParaPolvo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                octopusInfoGUI.setVisible(true);
                setVisible(false);
            }
        });
        panelFlor.add(btnTrocarParaPolvo);

        JButton btnTrocarParaCelulares = new JButton("Ver Celulares");
        btnTrocarParaCelulares.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                celularInfoGUI.setVisible(true);
                setVisible(false);
            }
        });
        panelFlor.add(btnTrocarParaCelulares);

        add(panelFlor);
        setVisible(true);

        octopusInfoGUI = new OctopusInfoGUI(this);
        celularInfoGUI = new CelularInfoGUI(this);
    }

    private void gerarFraseFlor() {
        String especie = txtEspecieFlor.getText();
        String bioma = txtBiomaFlor.getText();
        String cor = txtCorFlor.getText();

        String frase = "A flor " + cor + " da espécie " + especie + " do bioma " + bioma + ".";
        lblFraseFlor.setText(frase);

        exibirImagem(especie.toLowerCase() + ".jpg"); // Assume que o nome da imagem é o mesmo que o nome da espécie em minúsculas com extensão .jpg
    }

    private void exibirImagem(String imageName) {
        String imagePath = "imagens/" + imageName; // Pasta onde as imagens estão localizadas
        File file = new File(imagePath);
        if (file.exists()) {
            ImageIcon imageIcon = new ImageIcon(imagePath);
            Image image = imageIcon.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT);
            lblImagemFlor.setIcon(new ImageIcon(image));
        } else {
            lblImagemFlor.setIcon(null);
            JOptionPane.showMessageDialog(this, "Imagem não encontrada: " + imageName, "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new FlowerInfoGUI();
            }
        });
    }
}

class OctopusInfoGUI extends JFrame {
    private JTextField txtRacaPolvo, txtHabitatPolvo, txtCorPolvo;
    private JLabel lblImagemPolvo, lblFrasePolvo;
    private JButton btnGerarFrasePolvo, btnTrocarParaFlores;
    private JButton btnMudarCor, btnSoltarTinta, btnNadar;

    private FlowerInfoGUI flowerInfoGUI;

    public OctopusInfoGUI(FlowerInfoGUI flowerInfoGUI) {
        this.flowerInfoGUI = flowerInfoGUI;

        setTitle("Informações de Polvos");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panelPolvo = new JPanel();
        panelPolvo.setLayout(new GridLayout(7, 2));

        panelPolvo.add(new JLabel("Raça:"));
        txtRacaPolvo = new JTextField();
        panelPolvo.add(txtRacaPolvo);

        panelPolvo.add(new JLabel("Habitat:"));
        txtHabitatPolvo = new JTextField();
        panelPolvo.add(txtHabitatPolvo);

        panelPolvo.add(new JLabel("Cor:"));
        txtCorPolvo = new JTextField();
        panelPolvo.add(txtCorPolvo);

        btnGerarFrasePolvo = new JButton("Gerar Frase");
        btnGerarFrasePolvo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                gerarFrasePolvo();
            }
        });
        panelPolvo.add(btnGerarFrasePolvo);

        lblFrasePolvo = new JLabel();
        panelPolvo.add(lblFrasePolvo);

        lblImagemPolvo = new JLabel();
        panelPolvo.add(lblImagemPolvo);

        btnMudarCor = new JButton("Mudar de Cor");
        btnMudarCor.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                lblFrasePolvo.setText("O polvo " + txtRacaPolvo.getText() + " está mudando de cor");
            }
        });
        panelPolvo.add(btnMudarCor);

        btnSoltarTinta = new JButton("Soltar Tinta");
        btnSoltarTinta.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                lblFrasePolvo.setText("O polvo " + txtRacaPolvo.getText() + " soltou tinta");
            }
        });
        panelPolvo.add(btnSoltarTinta);

        btnNadar = new JButton("Nadar");
        btnNadar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                lblFrasePolvo.setText("O polvo do " + txtHabitatPolvo.getText() + " está nadando");
            }
        });
        panelPolvo.add(btnNadar);

        btnTrocarParaFlores = new JButton("Ver Flores");
        btnTrocarParaFlores.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                flowerInfoGUI.setVisible(true);
                setVisible(false);
            }
        });
        panelPolvo.add(btnTrocarParaFlores);

        add(panelPolvo);
        setVisible(false);
    }

    private void gerarFrasePolvo() {
        String raca = txtRacaPolvo.getText();
        String habitat = txtHabitatPolvo.getText();
        String cor = txtCorPolvo.getText();

        String frase = "O polvo " + cor + " da raça " + raca + " do habitat " + habitat + ".";
        lblFrasePolvo.setText(frase);

        exibirImagem(cor.toLowerCase() + "_polvo.jpg"); // Assume que o nome da imagem é o mesmo que o nome da cor do polvo em minúsculas com extensão .jpg
    }

    private void exibirImagem(String imageName) {
        String imagePath = "imagens/" + imageName; // Pasta onde as imagens estão localizadas
        File file = new File(imagePath);
        if (file.exists()) {
            ImageIcon imageIcon = new ImageIcon(imagePath);
            Image image = imageIcon.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT);
            lblImagemPolvo.setIcon(new ImageIcon(image));
        } else {
            lblImagemPolvo.setIcon(null);
            JOptionPane.showMessageDialog(this, "Imagem não encontrada: " + imageName, "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}

class CelularInfoGUI extends JFrame {
    private JTextField txtMarcaCelular, txtCorCelular, txtDataLancamento;
    private JLabel lblImagemCelular, lblFraseCelular;
    private JButton btnGerarFrase, btnTrocarParaFlores;
    private JButton btnLigar, btnConectarWifi, btnAbrirApp;

    private FlowerInfoGUI flowerInfoGUI;

    public CelularInfoGUI(FlowerInfoGUI flowerInfoGUI) {
        this.flowerInfoGUI = flowerInfoGUI;

        setTitle("Informações de Celulares");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panelCelular = new JPanel();
        panelCelular.setLayout(new GridLayout(7, 2));

        panelCelular.add(new JLabel("Marca:"));
        txtMarcaCelular = new JTextField();
        panelCelular.add(txtMarcaCelular);

        panelCelular.add(new JLabel("Cor:"));
        txtCorCelular = new JTextField();
        panelCelular.add(txtCorCelular);

        panelCelular.add(new JLabel("Data de Lançamento:"));
        txtDataLancamento = new JTextField();
        panelCelular.add(txtDataLancamento);

        btnGerarFrase = new JButton("Gerar Frase");
        btnGerarFrase.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                gerarFrase();
            }
        });
        panelCelular.add(btnGerarFrase);

        lblFraseCelular = new JLabel();
        panelCelular.add(lblFraseCelular);

        lblImagemCelular = new JLabel();
        panelCelular.add(new JLabel("Imagem:"));
        panelCelular.add(lblImagemCelular);

        btnLigar = new JButton("Ligar");
        btnLigar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                lblFraseCelular.setText("O celular " + txtMarcaCelular.getText() + " está ligando");
            }
        });
        panelCelular.add(btnLigar);

        btnConectarWifi = new JButton("ConectarWifi");
        btnConectarWifi.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                lblFraseCelular.setText("O celular " + txtCorCelular.getText() + " está conectado a internet");
            }
        });
        panelCelular.add(btnConectarWifi);

        btnAbrirApp = new JButton("AbrirApp");
        btnAbrirApp.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                lblFraseCelular.setText("Abrindo o CandyCrush no celular de " + txtDataLancamento.getText());
            }
        });
        panelCelular.add(btnAbrirApp);

        btnTrocarParaFlores = new JButton("Ver Flores");
        btnTrocarParaFlores.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                flowerInfoGUI.setVisible(true);
                setVisible(false);
            }
        });
        panelCelular.add(btnTrocarParaFlores);

        add(panelCelular);
        setVisible(false);
    }

    private void gerarFrase() {
        String marca = txtMarcaCelular.getText();
        String cor = txtCorCelular.getText();
        String dataLancamento = txtDataLancamento.getText();

        String frase = "O celular " + marca + " é da cor " + cor + " lançado em " + dataLancamento;
        lblFraseCelular.setText(frase);

        exibirImagem(marca.toLowerCase() + ".jpg"); // Assume que o nome da imagem é o mesmo que o nome da espécie em minúsculas com extensão .jpg;
    }

    private void exibirImagem(String imageName) {
        String imagePath = "imagens/" + imageName; // Pasta onde as imagens estão localizadas
        File file = new File(imagePath);
        if (file.exists()) {
            ImageIcon imageIcon = new ImageIcon(imagePath);
            Image image = imageIcon.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT);
            lblImagemCelular.setIcon(new ImageIcon(image));
        } else {
            lblImagemCelular.setIcon(null);
            JOptionPane.showMessageDialog(this, "Imagem não encontrada: " + imageName, "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}
