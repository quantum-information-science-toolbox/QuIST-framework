package org.quist.qubits.operators.single;

import org.junit.jupiter.api.Test;
import org.quist.qubits.Qubit;
import org.quist.qubits.math.ComplexNumber;

import static org.junit.runner.JUnitCore.runClasses;

class PauliXTest {

    public static void main(String[] args) {

        runClasses(PauliXTest.class);

    }

    @Test
    void testOnePauliX() {

        Qubit qubit = new Qubit(1L);

        ComplexNumber[] qubitAmplitudes;

        qubitAmplitudes = qubit.getAmplitudes();

        assert (qubitAmplitudes[0].modulus() == 1.0);
        assert (qubitAmplitudes[1].modulus() == 0.0);


        qubit.applyPauliX();

        qubit.measure();


        qubitAmplitudes = qubit.getAmplitudes();

        assert (qubitAmplitudes[0].modulus() == 0.0);
        assert (qubitAmplitudes[1].modulus() == 1.0);

        assert (qubit.getFinalOutcomeAfterMeasurement() == 1);

    }

    @Test
    void testTwoPauliX() {

        Qubit qubit = new Qubit(2L);

        ComplexNumber[] qubitAmplitudes;

        qubitAmplitudes = qubit.getAmplitudes();

        assert (qubitAmplitudes[0].modulus() == 1.0);
        assert (qubitAmplitudes[1].modulus() == 0.0);


        qubit.applyPauliX();

        qubit.applyPauliX();

        qubit.measure();


        qubitAmplitudes = qubit.getAmplitudes();

        assert (qubitAmplitudes[0].modulus() == 1.0);
        assert (qubitAmplitudes[1].modulus() == 0.0);

        assert (qubit.getFinalOutcomeAfterMeasurement() == 0);

    }

}