// package com.example.demo.dto;

// public class JwtResponse {

//     private String token;

//     public JwtResponse() {}

//     public JwtResponse(String token) {
//         this.token = token;
//     }

//     public String getToken() {
//         return token;
//     }

//     public void setToken(String token) {
//         this.token = token;
//     }
// }

package com.example.demo.dto;

public class ItPolicyMasterDto {
    
    // Minimal fields (can add more later)
    private String id;
    private String name;

    // Constructors
    public ItPolicyMasterDto() {}

    public ItPolicyMasterDto(String id, String name) {
        this.id = id;
        this.name = name;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
