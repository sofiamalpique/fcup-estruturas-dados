class Losango {
    public static void main(String[] args) {
        int n = 13;
        int middle = (n / 2);

        for (int i = 0; i < n; i++) {
            String line = "";

            if (i < middle) {
                for (int j = 0; j < n; j++) {
                    if (j < middle - i) {
                        line = line + ".";
                    } else if (j >= middle - i && j <= middle + i) {
                        line = line + "#";
                    } else {
                        line = line + ".";
                    }
                }
            } else if (i == middle) {

                for (int g = 0; g < n; g++) {
                    line = line + "#";
                }

            } else {
                for (int h = 0; h < n; h++) {
                    if (h < middle + i + 1 - n) {
                        line = line + ".";
                    } else if (h >= middle + i + 1 - n && h <= middle + n - i - 1) {
                        line = line + "#";
                    } else {
                        line = line + ".";
                    }
                }
            }
            System.out.println(line);

        }

    }

}