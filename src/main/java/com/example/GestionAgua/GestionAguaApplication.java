package com.example.GestionAgua;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Random;

@SpringBootApplication
@EnableScheduling
public class GestionAguaApplication {

    public static void main(String[] args) {
        SpringApplication.run(GestionAguaApplication.class, args);
    }
}

@Service
class SensorDataService {

    @Autowired
    private SensorDataRepository sensorDataRepository;

    private Random random = new Random();

    // Simulación de fugas a intervalos regulares
    @Scheduled(fixedRate = 10000) // Cada 10 segundos
    public void simulateLeaks() {
        double simulatedPressure = 10 + random.nextDouble() * 40; // Genera presión entre 10 y 50
        String sensorId = "sensor_pressure_1";

        // Guardar los datos en la base de datos
        SensorData sensorData = new SensorData();
        sensorData.setSensorId(sensorId);
        sensorData.setValue(simulatedPressure);
        sensorDataRepository.save(sensorData);

        if (simulatedPressure < 20) {
            System.out.println("ALERTA: Baja presión detectada en el sensor " + sensorId + ". Posible fuga.");
        } else {
            System.out.println("INFO: Presión normal detectada en el sensor " + sensorId + ".");
        }
    }

    // Simulación de activación de riego a intervalos regulares
    @Scheduled(fixedRate = 15000) // Cada 15 segundos
    public void simulateIrrigation() {
        double simulatedHumidity = 10 + random.nextDouble() * 60; // Genera humedad entre 10 y 70
        String sensorId = "sensor_humidity_1";

        // Guardar los datos en la base de datos
        SensorData sensorData = new SensorData();
        sensorData.setSensorId(sensorId);
        sensorData.setValue(simulatedHumidity);
        sensorDataRepository.save(sensorData);

        if (simulatedHumidity < 30) {
            System.out.println("ACCION: Activando riego para el sensor " + sensorId + ". Humedad baja detectada: " + simulatedHumidity);
        } else {
            System.out.println("INFO: Humedad suficiente para el sensor " + sensorId + ". Valor actual: " + simulatedHumidity);
        }
    }

    // Simulación de neutralización de pH a intervalos regulares
    @Scheduled(fixedRate = 20000) // Cada 20 segundos
    public void simulatePHNeutralization() {
        double simulatedPH = 6 + random.nextDouble() * 4; // Genera pH entre 6 y 10
        String sensorId = "sensor_ph_1";

        // Guardar los datos en la base de datos
        SensorData sensorData = new SensorData();
        sensorData.setSensorId(sensorId);
        sensorData.setValue(simulatedPH);
        sensorDataRepository.save(sensorData);

        if (simulatedPH < 7) {
            System.out.println("ACCION: Neutralización iniciada para el sensor " + sensorId + ". pH bajo detectado: " + simulatedPH);
        } else if (simulatedPH > 9) {
            System.out.println("ACCION: Neutralización iniciada para el sensor " + sensorId + ". pH alto detectado: " + simulatedPH);
        } else {
            System.out.println("INFO: pH dentro de los parámetros normales para el sensor " + sensorId + ". Valor actual: " + simulatedPH);
        }
    }
}


