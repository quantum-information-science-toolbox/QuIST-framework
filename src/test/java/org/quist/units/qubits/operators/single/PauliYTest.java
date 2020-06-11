package org.quist.units.qubits.operators.single;

import org.junit.jupiter.api.Test;
import org.quist.units.qubits.Qubit;
import org.quist.units.qubits.math.ComplexNumber;

import static org.junit.runner.JUnitCore.runClasses;

class PauliYTest {

    public static void main(String[] args) {

        runClasses(PauliYTest.class);

    }

    @Test
    void testOnePauliY() {

        Qubit qubit = new Qubit(1L);

        ComplexNumber[] qubitAmplitudes;

        qubitAmplitudes = qubit.getAmplitudes();

        assert (qubitAmplitudes[0].modulus() == 1.0);
        assert (qubitAmplitudes[1].modulus() == 0.0);


        qubit.applyPauliY();

        qubit.measure();


        qubitAmplitudes = qubit.getAmplitudes();

        assert (qubitAmplitudes[0].modulus() == 0.0);
        assert (qubitAmplitudes[1].modulus() == 1.0);

        assert (qubit.getFinalOutcomeAfterMeasurement() == 1);

    }

    @Test
    void testTwoPauliY() {

        Qubit qubit = new Qubit(2L);

        ComplexNumber[] qubitAmplitudes;

        qubitAmplitudes = qubit.getAmplitudes();

        assert (qubitAmplitudes[0].modulus() == 1.0);
        assert (qubitAmplitudes[1].modulus() == 0.0);


        qubit.applyPauliY();

        qubit.applyPauliY();

        qubit.measure();


        qubitAmplitudes = qubit.getAmplitudes();

        assert (qubitAmplitudes[0].modulus() == 1.0);
        assert (qubitAmplitudes[1].modulus() == 0.0);

        assert (qubit.getFinalOutcomeAfterMeasurement() == 0);

    }

}