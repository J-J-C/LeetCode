package math;

public class Num223_RectangleArea {

    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {

        int areaA = Math.abs(C - A) * Math.abs(D - B);
        int areaB = Math.abs(H - F) * Math.abs(G - E);

        int result = 0;
        // check different cases
        int leftX = A < E ? E : A;
        int rightX = C > G ? G : C;
        int lowY = B < F ? F : B;
        int highY = D < H ? D : H;

        int width = Math.abs(rightX - leftX);
        int height = Math.abs(highY - lowY);
        int overlap = 0;
        // sometime overlap may not hapeen
        if (rightX > leftX && highY > lowY) {
            return areaA + areaB - width * height;
        }
        return areaA + areaB;
    }
}
