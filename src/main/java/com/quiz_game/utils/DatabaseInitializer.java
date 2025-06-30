package com.quiz_game.utils;

import com.quiz_game.models.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseInitializer {
    public static void initializeDatabase() {
        // Check if questions already exist
        if (questionsExist()) {
            return;
        }

        // Sunamganj-specific questions
        String[][] questions = {
                {"Where is Sunamganj district located in Bangladesh?", "Rajshahi", "Sylhet", "Khulna", "Barisal", "2"},
                {"Which river flows through Sunamganj town?", "Padma", "Surma", "Meghna", "Jamuna", "2"},
                {"Which country borders Sunamganj to the north?", "Nepal", "India", "Myanmar", "Bhutan", "2"},
                {"What is the name of the famous haor in Sunamganj?", "Hakaluki Haor", "Tanguar Haor", "Chalan Beel", "Atrai Haor", "2"},
                {"Tanguar Haor is recognized as what kind of site?", "UNESCO Heritage Site", "Ramsar Site", "Biosphere Reserve", "World Lake", "2"},
                {"Who was Hason Raja?", "Freedom Fighter", "Sufi Saint", "Landlord and Poet", "Baul Singer from Kolkata", "3"},
                {"What museum in Sunamganj is dedicated to Hason Raja?", "Sylhet Museum", "Hason Museum", "Heritage Palace", "Hason Raja Museum", "4"},
                {"Which festival is celebrated in Sunamganj with folk songs?", "Nobanno Utsab", "Baul Mela", "Hason Mela", "New Year Fair", "3"},
                {"What musical instrument is common in Sunamganj folk songs?", "Sitar", "Tabla", "Ektara", "Guitar", "3"},
                {"Which dialect is widely spoken in Sunamganj?", "Chittagonian", "Chakma", "Sylheti", "Noakhali", "3"},
                {"When do Sunamganj haors flood?", "Summer", "Monsoon", "Winter", "Spring", "2"},
                {"Which upazila is nearest to Tanguar Haor?", "Jagannathpur", "Sadar", "Tahirpur", "Derai", "3"},
                {"What kind of ecosystem is Tanguar Haor?", "Forest", "Mountain valley", "Wetland", "River delta", "3"},
                {"Which bird visits Tanguar Haor in winter?", "Peacock", "Parrot", "Migratory Ducks", "Eagle", "3"},
                {"What is a major economic activity in Sunamganj?", "Tea Plantation", "Shipbuilding", "Fishing", "Textile", "3"},
                {"Sunamganj is famous for which crop?", "Jute", "Wheat", "Boro Rice", "Sugarcane", "3"},
                {"What resource is extracted from Sunamganj hills?", "Coal", "Natural Gas", "Sand & Stones", "Oil", "3"},
                {"Which power plant is in Sunamganj?", "Kaptai", "Tanguar", "None", "Mymensingh Hydro", "3"},
                {"Sunamganj receives large remittance from:", "Education Sector", "Tourism", "Expat Workers", "IT Sector", "3"},
                {"What project is improving haor transport?", "Padma Project", "Meghna Plan", "Haor Infrastructure Project", "Delta Plan", "3"}
        };

        // Insert questions into database
        String query = "INSERT INTO questions (question_text, option1, option2, option3, option4, correct_answer) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            for (String[] question : questions) {
                stmt.setString(1, question[0]);
                stmt.setString(2, question[1]);
                stmt.setString(3, question[2]);
                stmt.setString(4, question[3]);
                stmt.setString(5, question[4]);
                stmt.setInt(6, Integer.parseInt(question[5]));
                stmt.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static boolean questionsExist() {
        String query = "SELECT COUNT(*) FROM questions";
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
