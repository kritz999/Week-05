package com.json.IPLandCensorAnalyzer;

public class IPLCensorAnalyzer {

        return team.replaceAll(" ([A-Za-z]+)$", " ***");
    }

    private static String redactPlayerName() {
        return "REDACTED";
    }

    // 🔹 Process JSON File
    public static void processJsonFile(String inputFile, String outputFile) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Map<String, Object>> matches = objectMapper.readValue(new File(inputFile), new TypeReference<>() {});

        for (Map<String, Object> match : matches) {
            match.put("team1", censorTeamName((String) match.get("team1")));
            match.put("team2", censorTeamName((String) match.get("team2")));
            match.put("player_of_the_match", redactPlayerName());
        }

        objectMapper.writeValue(new File(outputFile), matches);
        System.out.println("✅ Censored JSON saved to " + outputFile);
    }

    // 🔹 Process CSV File
    public static void processCsvFile(String inputFile, String outputFile) throws IOException {
        try (CSVReader reader = new CSVReader(new FileReader(inputFile));
             CSVWriter writer = new CSVWriter(new FileWriter(outputFile))) {

            List<String[]> allRows = reader.readAll();
            List<String[]> censoredRows = new ArrayList<>();

            // Process header
            censoredRows.add(allRows.get(0));

            // Process data rows
            for (int i = 1; i < allRows.size(); i++) {
                String[] row = allRows.get(i);
                row[1] = censorTeamName(row[1]); // team1
                row[2] = censorTeamName(row[2]); // team2
                row[3] = redactPlayerName();     // player_of_the_match
                censoredRows.add(row);
            }

            writer.writeAll(censoredRows);
            System.out.println(" Censored CSV saved to " + outputFile);
        }
    }
public static void main(String[] args) {
    try {
        processJsonFile("ipl_matches.json", "ipl_censored.json");
        processCsvFile("ipl_matches.csv", "ipl_censored.csv");
    } catch (IOException e) {
        e.printStackTrace();
    }
}

}
