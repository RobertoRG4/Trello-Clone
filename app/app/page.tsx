"use client";

import Task from "@/components/Task";
import { useGetTasks } from "@/hooks/useGetTasks";

export default function Home() {
  const { tasks, loading, error } = useGetTasks();

  if (loading) {
    return (
      <div className="flex justify-center items-center h-screen w-screen">
        Loading
      </div>
    );
  }

  if (error) {
    return <div className="text-center">{error}</div>;
  }

  return (
    <div className="">
      <main className="">
        <h1 className="text-center p-4">Trello - Clone</h1>
        {tasks.map(({ id, description, status }) => (
          <Task key={id} description={description} status={status} />
        ))}
      </main>
    </div>
  );
}
