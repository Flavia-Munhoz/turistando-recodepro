package application;

import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) throws SQLException {

		String opcao = "s";
		String escolha;

		while (!opcao.equalsIgnoreCase("0")) {
			String texto = "Agência Turistando \n" + "Seja Bem Vindo\n" + "Digite sua opcão: \n" + "1 -  Agência\n"
					+ "2 -  Destinos\n" + "3 - Promoções\n" + "0 - Sair";
			opcao = JOptionPane.showInputDialog(texto);

			switch (opcao) {
			case "1":
				String opcao1 = "Agência Turistando \n" + "AGÊNCIA\n" + "Digite sua opcão: \n" + "1 -  Adiconar\n"
						+ "2 -  Consultar\n" + "3 - Atualizar\n" + "4 - Excluir\n" + "0 - Voltar\n";
				escolha = JOptionPane.showInputDialog(opcao1);
				switch (escolha) {
				case "1":
					Agencia agencia = new Agencia();
					String nome = JOptionPane.showInputDialog("Nome da Agência:");
					String cnpj = JOptionPane.showInputDialog("CNPJ:");
					String telefone = JOptionPane.showInputDialog("Telefone:");
					String email = JOptionPane.showInputDialog("E-mail:");
					agencia.cadastrarAgencia(cnpj, nome, telefone, email);
					JOptionPane.showMessageDialog(null, "Agencia Cadastrada com sucesso!");
					break;
				case "2":
					Agencia a = new Agencia();
					JOptionPane.showMessageDialog(null, a.consultarAgencia2());
					break;
				case "3":
					Agencia agencia2 = new Agencia();
					int id_agencia2 = Integer.valueOf(JOptionPane.showInputDialog("ID Agência:"));
					String nome2 = JOptionPane.showInputDialog("Nome da Agência:");
					String telefone2 = JOptionPane.showInputDialog("Telefone:");
					String email2 = JOptionPane.showInputDialog("E-mail:");
					agencia2.updateAgencia(id_agencia2, nome2, telefone2, email2);
					JOptionPane.showMessageDialog(null, "Agencia Cadastrada com sucesso!");
					break;
				case "4":
					Agencia agencia3 = new Agencia();
					int id_agencia3 = Integer.valueOf(JOptionPane.showInputDialog("ID Agência:"));
					agencia3.deletAgencia(id_agencia3);
					break;
				case "0":
					break;
				default:
					break;
				}
				break;
			case "2":
				String opcao2 = "Agência Turistando \n" + "DESTINOS\n" + "Digite sua opcão: \n" + "1 -  Adiconar\n"
						+ "2 -  Consultar\n" + "3 - Atualizar\n" + "4 - Excluir\n" + "0 - Voltar\n";
				escolha = JOptionPane.showInputDialog(opcao2);
				switch (escolha) {
				case "1":
					Destinos destino = new Destinos();
					String cidade = JOptionPane.showInputDialog("Cidade:");
					String pais = JOptionPane.showInputDialog("Pais:");
					String estado = JOptionPane.showInputDialog("Estado:");
					float valor = Float.valueOf(JOptionPane.showInputDialog("Valor:"));
					destino.cadastrarDestino(pais, estado, cidade, valor);
					JOptionPane.showMessageDialog(null, "Destino Cadastrado com sucesso!");
					break;
				case "2":
					Destinos d = new Destinos();
					JOptionPane.showMessageDialog(null, d.consultarDestinos2());
				case "3":
					Destinos destino3 = new Destinos();
					int id_destino3 = Integer.valueOf(JOptionPane.showInputDialog("ID Destino:"));
					String cidade3 = JOptionPane.showInputDialog("Cidade:");
					String pais3 = JOptionPane.showInputDialog("Pais:");
					String estado3 = JOptionPane.showInputDialog("Estado:");
					float valor3 = Float.valueOf(JOptionPane.showInputDialog("Valor:"));
					destino3.updateDestino(id_destino3, cidade3, estado3, pais3, valor3);
					JOptionPane.showMessageDialog(null, "Destino Cadastrado com sucesso!");
					break;
				case "4":
					Destinos dest = new Destinos();
					int id_dest = Integer.valueOf(JOptionPane.showInputDialog("Id Destino: "));
					dest.deletDestino(id_dest);
					break;
				case "0":
					break;
				default:
					break;
				}
				break;

			case "3":
				String opcao3 = "Agência Turistando \n" + "PROMOÇÕES\n" + "Digite sua opcão: \n" + "1 -  Adiconar\n"
						+ "2 -  Consultar\n" + "3 - Atualizar\n" + "4 - Excluir\n" + "0 - Voltar\n";
				escolha = JOptionPane.showInputDialog(opcao3);
				switch (escolha) {
				case "1":
					Promo promo = new Promo();
					int desconto = Integer.valueOf(JOptionPane.showInputDialog("Desconto(%): "));
					int id_destino = Integer.valueOf(JOptionPane.showInputDialog("ID Destino:"));
					promo.cadastrarPromo(desconto, id_destino);
					JOptionPane.showMessageDialog(null, "Promoção Cadastrada com sucesso!");
					break;

				case "2":
					Promo p = new Promo();
					p.consultarPromo();
					break;
				case "3":
					Promo pr = new Promo();
					int desconto2 = Integer.valueOf(JOptionPane.showInputDialog("Desconto(%): "));
					int id_destino2 = Integer.valueOf(JOptionPane.showInputDialog("ID Destino:"));
					pr.updatePromo(id_destino2, desconto2);
					JOptionPane.showMessageDialog(null, "Promoção atualizada com sucesso!");
					break;
				case "4":
					Promo pd = new Promo();
					int id_pd = Integer.valueOf(JOptionPane.showInputDialog("Id Promo: "));
					pd.deletePromo(id_pd);
					break;
				case "0":
					break;
				default:
					break;
				}
				break;

			}
		}
	}
}
