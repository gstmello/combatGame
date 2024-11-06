package main;
import java.util.Scanner;

class Champion {
    private String name;
    private int life;
    private int attack;
    private int armor;

    public Champion(String name, int life, int attack, int armor) {
        this.name = name;
        this.life = life;
        this.attack = attack;
        this.armor = armor;
    }

    public void takeDamage(Champion other) {
        int damage = Math.max(other.attack - this.armor, 1);
        this.life = Math.max(this.life - damage, 0);
    }

    public String status() {
        return life > 0 ? name + ": " + life + " de vida" : name + ": morreu";
    }

    public boolean isAlive() {
        return life > 0;
    }
}

public class CombatGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Leitura dos dados do primeiro campeão
        System.out.println("Digite os dados do primeiro campeão:");
        System.out.print("Nome: ");
        String name1 = scanner.nextLine();
        System.out.print("Vida inicial: ");
        int life1 = scanner.nextInt();
        System.out.print("Ataque: ");
        int attack1 = scanner.nextInt();
        System.out.print("Armadura: ");
        int armor1 = scanner.nextInt();
        scanner.nextLine();  // Limpar o buffer

        Champion champion1 = new Champion(name1, life1, attack1, armor1);

        // Leitura dos dados do segundo campeão
        System.out.println("Digite os dados do segundo campeão:");
        System.out.print("Nome: ");
        String name2 = scanner.nextLine();
        System.out.print("Vida inicial: ");
        int life2 = scanner.nextInt();
        System.out.print("Ataque: ");
        int attack2 = scanner.nextInt();
        System.out.print("Armadura: ");
        int armor2 = scanner.nextInt();

        Champion champion2 = new Champion(name2, life2, attack2, armor2);

        // Leitura do número de turnos
        System.out.print("Quantos turnos você deseja executar? ");
        int turns = scanner.nextInt();

        // Execução dos turnos de combate
        for (int turn = 1; turn <= turns; turn++) {
            System.out.println("Resultado do turno " + turn + ":");

            champion1.takeDamage(champion2);
            champion2.takeDamage(champion1);

            System.out.println(champion1.status());
            System.out.println(champion2.status());

            // Verifica se algum dos campeões morreu
            if (!champion1.isAlive() || !champion2.isAlive()) {
                break;
            }
        }

        System.out.println("### FIM DO COMBATE ###");
        scanner.close();
    }
}
