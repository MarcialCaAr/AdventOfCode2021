package librerias;

public class Tuple<firstTipe, secondTipe> {
    public firstTipe first;
    public secondTipe second;

    public Tuple(firstTipe first, secondTipe second) {
        this.first = first;
        this.second = second;
    }

    public firstTipe getFirst() {
        return this.first;
    }

    public secondTipe getSecond() {
        return this.second;
    }

    public void setFirst(firstTipe replaceFirst) {
        this.first = replaceFirst;
    }

    public void setSecond(secondTipe replaceSecond) {
        this.second = replaceSecond;
    }

    @Override
    public String toString() {
        return "(" + first + "," + second + ")";
    }

    @Override
    public boolean equals(Object object) {
        boolean equal = false;

        if (this == object) {
            equal = true;
        } else if (object instanceof Tuple<?, ?>) {
            // Check that object is an instance of Pair<?, ?>, this will also null check.
            // Then just case object to Pair<?, ?> like.
            Tuple<?, ?> pair = (Tuple<?, ?>) object;

            if (((this.first == null && pair.first == null) || (this.first != null && this.first.equals(pair.first))) &&
                    ((this.second == null && pair.second == null) || (this.second != null && this.second.equals(pair.second)))) {
                equal = true;
            }
        }
        return equal;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((first == null) ? 0 : first.hashCode());
        result = prime * result + ((second == null) ? 0 : second.hashCode());
        return result;
    }
}