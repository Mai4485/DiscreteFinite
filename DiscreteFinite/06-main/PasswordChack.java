public class PasswordChack {
    private State currentState = State.S0;
    public void process(String password) {
        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            transition(c, i);
        }
        System.out.println("Final State: " + currentState);
        if (currentState == State.S9) {
            System.out.println("Strong Password");
        } else {
            System.out.println("Weak Password");
        }
    }

    private void transition(char c, int num) {
        State previousState = currentState;
        switch (currentState) {
            case S0: {
                if (Character.isDigit(c))
                    currentState = State.S1;
                else if (Character.isLowerCase(c))
                    currentState = State.S2;
                else if (Character.isUpperCase(c))
                    currentState = State.S3;
                break;
            }

            case S1: {
                if (Character.isDigit(c))
                    currentState = State.S1;
                else if (Character.isUpperCase(c))
                    currentState = State.S4;
                else if (Character.isLowerCase(c))
                    currentState = State.S5;
                break;
            }

            case S2: {
                if (Character.isLowerCase(c))
                    currentState = State.S2;
                else if (Character.isDigit(c))
                    currentState = State.S5;
                else if (Character.isUpperCase(c))
                    currentState = State.S6;
                break;
            }

            case S3: {
                if (Character.isUpperCase(c))
                    currentState = State.S3;
                else if (Character.isDigit(c))
                    currentState = State.S4;
                else if (Character.isLowerCase(c))
                    currentState = State.S6;
                break;
            }

            case S4: {
                if (Character.isUpperCase(c) || Character.isDigit(c))
                    currentState = State.S4;
                else if (Character.isLowerCase(c))
                    currentState = State.S7;
                break;
            }

            case S5: {
                if (Character.isDigit(c) || Character.isLowerCase(c))
                    currentState = State.S5;
                else if (Character.isUpperCase(c))
                    currentState = State.S7;
                break;
            }

            case S6: {
                if (Character.isUpperCase(c) || Character.isLowerCase(c))
                    currentState = State.S6;
                else if (Character.isDigit(c))
                    currentState = State.S7;
                break;
            }

            case S8: {
                if (Character.isDigit(c) || Character.isLowerCase(c) || Character.isUpperCase(c)) {
                    currentState = State.S7;
                    break;
                }
            }
        }

        if (currentState == State.S7) {
            if (num > 7) {
                currentState = State.S9;
            } else {
                currentState = State.S8;
            }
        }
        System.out.println(c + " : " + previousState + " -> " + currentState);
    }
}
