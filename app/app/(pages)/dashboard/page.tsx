"use client";
import Task from "@/components/Task";
import { useGetTasks } from "@/hooks/useGetTasks";
import { useState } from "react";

import { FaPlus } from "react-icons/fa6";
import ModalTask from "@/components/ModalTask";
import usePostTask from "@/hooks/usePostTask";
const Page = () => {
  const { tasks, loading, error } = useGetTasks();
  const [visibleModal, setVisibleModal] = useState<boolean>(false);
  const [descriptionTaskCreate, setDescriptionTask] = useState<string>("");
  const [statusTaskCreate, setStatusTask] = useState<string>("");

  const postTask = usePostTask();
  const handleOnClick = () => {
    setVisibleModal((prev) => !prev);
  };
  const handleCreateTask = (e: React.FormEvent<HTMLFormElement>) => {
    e.preventDefault();
    postTask(descriptionTaskCreate, statusTaskCreate);
    console.log("enviado");
  };
  const handleOnChange = (
    e: React.ChangeEvent<HTMLInputElement | HTMLSelectElement>
  ) => {
    const { target } = e;
    switch (target.name) {
      case "description":
        setDescriptionTask(target.value);
        break;
      case "status":
        setStatusTask(target.value);
        break;
      default:
        console.log("Inviable option!");
        break;
    }
  };

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
    <div>
      <main>
        {visibleModal && (
          <ModalTask
            handleCreateTask={handleCreateTask}
            handleOnClick={handleOnClick}
            handleOnChange={handleOnChange}
          />
        )}
        <h1 className="text-center p-4">Trello - Clone</h1>
        <div className="p-3">
          <button className="p-4 cursor-pointer" onClick={handleOnClick}>
            <FaPlus />
          </button>
          {tasks.map(({ id, description, status }) => (
            <Task key={id} description={description} status={status} />
          ))}
        </div>
      </main>
    </div>
  );
};
export default Page;
