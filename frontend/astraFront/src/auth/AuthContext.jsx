// cspell:disable
import { createContext, useContext, useState, useEffect } from "react";

const AuthContext = createContext(null);

const API_URL = "http://localhost:8080";

export const AuthProvider = ({ children }) => {
  const [token, setToken] = useState(null);
  const [loading, setLoading] = useState(false);

  // ⚡ au montage : on relit le token depuis localStorage → session persistante
  useEffect(() => {
    const storedToken = localStorage.getItem("jwt");
    if (storedToken) {
      setToken(storedToken);
    }
  }, []);

  const isAuthenticated = !!token;

  const login = async (mail, password) => {
    setLoading(true);
    try {
      const res = await fetch(`${API_URL}/api/auth/login`, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ mail, password }),
      });

      if (!res.ok) {
        return false;
      }

      const data = await res.json();
      const jwt = data.token;

      localStorage.setItem("jwt", jwt);
      setToken(jwt);
      return true;
    } catch (e) {
      console.error("Erreur login", e);
      return false;
    } finally {
      setLoading(false);
    }
  };

  const register = async (nom, mail, password, type) => {
    setLoading(true);
    try {
      const res = await fetch(`${API_URL}/api/utilisateurs`, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ nom, mail, password, type }),
      });

      return res.ok;
    } catch (e) {
      console.error("Erreur inscription", e);
      return false;
    } finally {
      setLoading(false);
    }
  };

  const logout = () => {
    localStorage.removeItem("jwt");
    setToken(null);
  };

  return (
    <AuthContext.Provider
      value={{ token, isAuthenticated, login, register, logout, loading }}
    >
      {children}
    </AuthContext.Provider>
  );
};

export const useAuth = () => useContext(AuthContext);
