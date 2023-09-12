// api.js
const API_BASE_URL = process.env.REACT_APP_API_BASE_URL;

export async function login(username, password) {
    const response = await fetch(`${API_BASE_URL}/hello-servlet`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded',
        },
        body: `username=${username}&password=${password}`,
    });
    return response;
}

