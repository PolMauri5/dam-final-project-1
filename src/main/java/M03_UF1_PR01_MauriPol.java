import java.util.Scanner;

public class M03_UF1_PR01_MauriPol {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        // una array de String infinitas
        String[] username = new String[1000];
        String[] password = new String[1000];
        String exit;
        int option;
        int optionRoot;
        System.out.println("Bienvenido a la aplicacion!");

        do {
            System.out.println("1. Register" + "\n" + "2. Login" + "\n" + "3. Entrar root" + "\n" + "4. Has olvidado la contraseña?" + "\n" + "5. Salir" + "\n \n" + "Pista: inicia sesion como 'Pikachu'");
            while (!scanner.hasNextInt()) {
                System.out.println("Tienes que introducir un numero");
                scanner.next();
            }
            option = scanner.nextInt();
            scanner.nextLine();

            //switch case menu principal
            switch (option) {

                case 1:
                    System.out.println("Introduce tu nombre de usuario: ");
                    String user = scanner.nextLine();

                    //si les coincideixen els characters ignora si està en majuscula o minuscula
                    while (user.equalsIgnoreCase("GUEST") || user.equalsIgnoreCase("ROOT")) {
                        System.out.println("El nombre de usuario no puede ser GUEST o ROOT");
                        System.out.println("Introduce tu nombre de usuario: ");
                        user = scanner.nextLine();
                    }

                    for (int i = 0; i < username.length; i++) {
                        //introdueix el usuari a la primera posicio buida
                        if (username[i] == null) {
                            username[i] = user;
                            break;
                        }
                        //comprova que el usuari no es repeteix
                        while (username[i].equals(user)) {
                            System.out.println("El usuario ya existe");
                            System.out.println("Introduce tu nombre de usuario: ");
                            user = scanner.nextLine();
                        }
                    }

                    System.out.println("Introduce tu contraseña: ");
                    String pass = scanner.nextLine();
                    //condicions per a una pw segura
                    while (pass.length() < 1 ||
                            !pass.matches(".*[!@#$%&?^*()-+,=<>/].*") ||
                            !pass.matches(".*[0-9].*") ||
                            !pass.matches(".*[A-Z].*") ||
                            !pass.matches(".*[a-z].*")) {

                        System.out.println("La contrtaseña debe tener: Mas de 8 caracteres, un numero, un caracter especial y una mayuscula y una minuscula");
                        System.out.println("Introdece tu contraseña: ");
                        pass = scanner.nextLine();
                    }

                    for (int i = 0; i < password.length; i++) {
                        if (password[i] == null) {
                            password[i] = pass;
                            break;
                        }
                    }
                    break;

                case 2:
                    boolean pikachuLogin = false;
                    String user2;
                    String pass2;

                    System.out.println("Introduce tu nombre de usuario: ");
                    user2 = scanner.nextLine();

                    for (int i = 0; i < username.length; i++) {
                        //comprova que el usuari existeix
                        if (username[i] == null) {
                            System.out.println("El usuario no existe");
                            break;
                        }
                        //si hi ha un usuari igual que el input demana la pw
                        // .equals Compara la cadena de texto contra un objeto. Devolverá true si las cadenas comparadas son iguales. En caso contrario devolverá false.
                        if (username[i].equals(user2) && !user2.equalsIgnoreCase("pikachu")) {
                            System.out.println("Introduce tu contraseña: ");
                            pass2 = scanner.nextLine();
                            //compaara que la pw es igual a la introduida
                            if (password[i].equals(pass2)) {
                                System.out.println("Bienvenido " + username[i]);
                            } else {
                                System.out.println("Contraseña incorrecta");
                            }
                            break;

                        } else if (username[i].equalsIgnoreCase("pikachu")) {
                            System.out.println("Introduce tu contraseña: ");
                            pass2 = scanner.nextLine();
                            if (password[i].equals(pass2)) {
                                pikachuLogin = true;
                            } else {
                                System.out.println("Contraseña incorrecta");
                            }
                            break;
                        }
                    }
                    if (pikachuLogin) {
                        int pikachuHealth = 100; //vida de pikachu
                        int charizardHealth = 100; //vida de charizard
                        int attack1 = 20; //ataque 1
                        int attack2 = 30; //ataque 2
                        int attack3 = 60; //ataque 3
                        int random; //posibilitat "random" de que un atac falli
                        int attackSelect; //ataque seleccionat
                        boolean thrown = true; //turno

                        System.out.println("Bienvenido " + user2 + " acabas de entrar al combate mas epico de toda tu vida \n" + "Pikachu vs Charizard \n");

                        while (pikachuHealth > 0 && charizardHealth > 0) {

                            while (thrown) {
                                System.out.println("Pikachu ataca: \n");
                                System.out.println("Que ataque quieres usar? \n");
                                System.out.println("1. Ataque rapido");
                                System.out.println("2. Ataque relampago");
                                System.out.println("3. Ataque bola voltio");

                                attackSelect = scanner.nextInt();

                                switch (attackSelect) {
                                    case 1:
                                        charizardHealth = charizardHealth - attack1;
                                        break;
                                    case 2:
                                        random = (int) (Math.random() * 5 + 1);
                                        if (random == 1) {
                                            System.out.println("El ataque falló");
                                        } else {
                                            charizardHealth = charizardHealth - attack2;
                                        }
                                        break;
                                    case 3:
                                        random = (int) (Math.random() * 2 + 1);
                                        if (random == 1) {
                                            System.out.println("El ataque falló");
                                        } else {
                                            charizardHealth = charizardHealth - attack3;
                                        }
                                        break;
                                }
                                if (charizardHealth > 0) {
                                    System.out.println("Charizard tiene " + charizardHealth + " de vida");
                                } else {
                                    System.out.println("Charizard ha muerto, gana Pikachu");
                                } thrown = false;
                            }

                            while (charizardHealth > 0 && !thrown) {
                                System.out.println("Charizard ataca");
                                System.out.println("Que ataque quieres usar?");
                                System.out.println("1. Mordisco");
                                System.out.println("2. Ataque ala");
                                System.out.println("3. Ataque fuego");

                                attackSelect = scanner.nextInt();

                                switch (attackSelect) {
                                    case 1:
                                        pikachuHealth = pikachuHealth - attack1;
                                        break;
                                    case 2:
                                        random = (int) (Math.random() * 5 + 1);
                                        if (random == 1) {
                                            System.out.println("El ataque fallo");
                                        } else {
                                            pikachuHealth = pikachuHealth - attack2;
                                        }
                                        break;
                                    case 3:
                                        random = (int) (Math.random() * 2 + 1);
                                        if (random == 1) {
                                            System.out.println("El ataque fallo");
                                        } else {
                                            pikachuHealth = pikachuHealth - attack3;
                                        }
                                        break;
                                }
                                if (pikachuHealth > 0) {
                                    System.out.println("Pikachu tiene " + pikachuHealth + " de vida");
                                } else {
                                    System.out.println("Pikachu ha muerto, gana Charizard");
                                } thrown = true;
                            }
                        }
                    }
                    break;

                case 3:
                    String root = "root";
                    System.out.println("Inroduce la contraseña de root: ");
                    String pswRoot = scanner.nextLine();
                    if (pswRoot.equals(root)) {
                        System.out.println("Bienvenido root");
                        System.out.println("1. Mostrar usuarios" + "\n" + "2. Mostrar contraseñas" + "\n" + "3. Cambiar nombre de usuario" + "\n" + "4. Cambiar contraseña" + "\n" + "5. Eliminar un usuario" + "\n" + "6. Salir");
                        optionRoot = scanner.nextInt();
                        scanner.nextLine();

                        switch (optionRoot) {
                            case 1:
                                int count1 = 1;
                                for (String s : username) {
                                    if (s == null) {
                                        break;
                                    }
                                    System.out.println(count1 + " " + s + "\n");
                                    count1++;
                                }
                                System.out.println("Si quiere salir pulse 1");
                                exit = scanner.nextLine();
                                while (!exit.equals("1")) {
                                    System.out.println("Opcion invalida, pulse 1 para salir: ");
                                    exit = scanner.nextLine();
                                }
                                break;

                            case 2:
                                int count2 = 1;
                                for (String s : password) {
                                    if (s == null) {
                                        break;
                                    }
                                    System.out.println(count2 + " " + s + "\n");
                                    count2++;
                                }
                                System.out.println("Si quiere salir pulse 1");
                                exit = scanner.nextLine();
                                while (!exit.equals("1")) {
                                    System.out.println("Opcion invalida, pulse 1 para salir: ");
                                    exit = scanner.nextLine();
                                }
                                break;

                            case 3:
                                System.out.println("Introduce el nombre de usuario que quieres cambiar: ");
                                String userChange = scanner.nextLine();
                                for (int i = 0; i < username.length; i++) {
                                    if (username[i] == null) {
                                        System.out.println("El usuario no existe");
                                        break;
                                    }

                                    if (username[i].equals(userChange)) {
                                        System.out.println("Introduce el nuevo nombre de usuario: ");
                                        String userChange2 = scanner.nextLine();
                                        username[i] = userChange2;
                                        System.out.println("El nombre de usuario ha sido cambiado");
                                        break;
                                    }
                                }
                                System.out.println("Si quiere salir pulse 1");
                                exit = scanner.nextLine();
                                while (!exit.equals("1")) {
                                    System.out.println("Opcion invalida, pulse 1 para salir: ");
                                    exit = scanner.nextLine();
                                }
                                break;


                            case 4:
                                System.out.println("Introduce el nombre de usuario del que quieres cambiar la contraseña: ");
                                String userChangePass = scanner.nextLine();
                                for (int i = 0; i < username.length; i++) {
                                    if (username[i] == null) {
                                        System.out.println("El usuario no existe");
                                        break;
                                    }
                                    if (username[i].equals(userChangePass)) {
                                        System.out.println("Introduce la nueva contraseña: ");
                                        String passChange = scanner.nextLine();
                                        password[i] = passChange;
                                        System.out.println("La contraseña ha sido cambiada");
                                        break;
                                    }
                                }
                                System.out.println("Si quiere salir pulse 1");
                                exit = scanner.nextLine();
                                while (!exit.equals("1")) {
                                    System.out.println("Opcion invalida, pulse 1 para salir: ");
                                    exit = scanner.nextLine();
                                }
                                break;

                            case 5:
                                System.out.println("Introduce el nombre de usuario que quieres eliminar: ");
                                String userDelete = scanner.nextLine();
                                for (int i = 0; i < username.length; i++) {
                                    if (username[i] == null) {
                                        System.out.println("El usuario no existe");
                                        break;
                                    }
                                    if (username[i].equals(userDelete)) {
                                        username[i] = null;
                                        password[i] = null;
                                        for (int j = i; j < username.length - 1; j++) {
                                            username[j] = username[j + 1];
                                            password[j] = password[j + 1];
                                        }
                                        System.out.println("El usuario ha sido eliminado");
                                        break;
                                    }
                                }
                                System.out.println("Si quiere salir pulse 1");
                                exit = scanner.nextLine();
                                while (!exit.equals("1")) {
                                    System.out.println("Opcion invalida, pulse 1 para salir: ");
                                    exit = scanner.nextLine();
                                }
                                break;
                            case 6:
                                System.out.println("Saliendo...");
                                break;
                        }
                    } else {
                        System.out.println("Contraseña incorrecta");
                    }
                    break;

                case 4:
                    System.out.println("Has olvidado la contraseña? Introduce tu nombre de usuario: ");
                    String userForgot = scanner.nextLine();
                    for (int i = 0; i < username.length; i++) {
                        if (username[i] == null) {
                            System.out.println("El usuario no existe");
                            break;
                        }
                        if (username[i].equals(userForgot)) {
                            System.out.println("Introduce tu nueva contraseña: ");
                            String passForgot = scanner.nextLine();
                            password[i] = passForgot;
                            System.out.println("La contraseña ha sido cambiada");
                            break;
                        }
                    }
                    break;

                case 5:
                    System.out.println("Saliendo...");
                    break;
            }
        } while (option != 6);
    }
}


