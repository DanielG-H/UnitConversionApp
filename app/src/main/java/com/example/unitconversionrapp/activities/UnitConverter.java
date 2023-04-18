package com.example.unitconversionrapp.activities;

import android.util.Log;

import java.util.HashMap;
import java.util.Map;

public class UnitConverter {
    private final String TAG = "UnitConverter";
    private final Map<String, Double> measureFactors = new HashMap<>();

    public UnitConverter() {
        setFactor("Meter(m)Inch(in)", 39.3701f);
        setFactor("Meter(m)Centimeter(cm)", 100.0f);
        setFactor("Meter(m)Feet(ft)", 3.2808f);

        setFactor("Inch(in)Meter(m)", 0.0254f);
        setFactor("Inch(in)Centimeter(cm)", 2.54f);
        setFactor("Inch(in)Feet(ft)", 0.08333f);

        setFactor("Centimeter(m)Meter(m)", 0.01f);
        setFactor("Centimeter(m)Inch(in)", 0.393701f);
        setFactor("Centimeter(m)Feet(ft)", 0.032808f);


        setFactor("Feet(ft)Meter(m)", 0.3048f);
        setFactor("Feet(ft)Centimeter(cm)", 30.48f);
        setFactor("Feet(ft)Inch(in)", 12.0f);
    }

    public void setFactor(String key, double factor) {
        measureFactors.put(key, factor);
    }

    public double getConversion(double firstUnitQuantity, String firstUnit, String secondUnit) {
        String key = firstUnit + secondUnit;
        if (measureFactors.containsKey(key)) {
            double factor = measureFactors.get(key);
            Log.d(TAG, "User quantity: " + firstUnitQuantity);
            Log.d(TAG, "Factor: " + factor);
            return factor * firstUnitQuantity;
        }
        return 0.0f;
    }
}