package ru.job4j.lambda;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class MatrixTransformTest {

    @Test
    public void matrixToList() {
        Integer[][] matrix = {
            {1, 2},
            {3, 4}
        };
        MatrixTransform res = new MatrixTransform();
        List<Integer> result = res.matrixTr(matrix);
        List<Integer> expected = List.of(1, 2, 3, 4);
        assertThat(result, is(expected));
    }
}
