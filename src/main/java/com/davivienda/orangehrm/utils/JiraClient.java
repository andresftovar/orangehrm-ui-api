package com.davivienda.orangehrm.utils;

import org.json.JSONObject;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class JiraClient {

    private static final String JIRA_BASE = "https://tudominio.atlassian.net";
    private static final String JIRA_USER = "tuemail@empresa.com";
    private static final String JIRA_TOKEN = "tu_api_token";
    private static final String PROJECT_KEY = "HRM";

    public static void createIssue(String summary, String description) {
        try {
            String auth = Base64.getEncoder().encodeToString((JIRA_USER + ":" + JIRA_TOKEN).getBytes());
            URL url = new URL(JIRA_BASE + "/rest/api/3/issue");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Authorization", "Basic " + auth);
            conn.setRequestProperty("Content-Type", "application/json");

            JSONObject fields = new JSONObject();
            JSONObject project = new JSONObject();
            project.put("key", PROJECT_KEY);
            JSONObject issueType = new JSONObject();
            issueType.put("name", "Bug");
            JSONObject fieldData = new JSONObject();
            fieldData.put("project", project);
            fieldData.put("summary", summary);
            fieldData.put("description", description);
            fieldData.put("issuetype", issueType);
            fields.put("fields", fieldData);

            try (OutputStream os = conn.getOutputStream()) {
                byte[] input = fields.toString().getBytes(StandardCharsets.UTF_8);
                os.write(input, 0, input.length);
            }

            int responseCode = conn.getResponseCode();
            System.out.println("Jira create issue response: " + responseCode);
            conn.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
