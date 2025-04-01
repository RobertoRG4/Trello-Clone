"use client";
import { useState, useEffect } from "react";

export const useGetTasks = () => {
  const [tasks, setTasks] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  useEffect(() => {
    const fetchTasks = async () => {
      try {
        const response = await fetch(
          `${process.env.NEXT_PUBLIC_API_URL}/api/tasks`,
          { method: "GET" }
        );
        if (!response.ok) throw new Error("Error al obtener datos");
        const result = await response.json();
        setTasks(result);
      } catch (err) {
        setError(err.message);
      } finally {
        setLoading(false);
      }
    };

    fetchTasks();
  }, []);

  return { tasks, loading, error };
};
