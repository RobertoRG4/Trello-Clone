"use client";

import { redirect } from "next/navigation";
import React, { useState } from "react";

const Page = () => {
  const [username, setUsername] = useState<string>("");
  const [password, setPassword] = useState<string>("");

  const handleSubmit = (e: React.FormEvent<HTMLFormElement>) => {
    e.preventDefault();
    console.log({ username, password });
    const response = fetch(`${process.env.NEXT_PUBLIC_API_URL}/api/login`, {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({ username, password }),
    });
    response.then((value) => {
      if (value.ok === true) {
        redirect("/dashboard");
      } else alert("invalid credentials!");
    });
  };
  const handleOnChange = (event: React.ChangeEvent<HTMLInputElement>) => {
    const { target } = event;
    switch (target.name) {
      case "user":
        setUsername(target.value);
        break;
      case "password":
        setPassword(target.value);
        break;
      default:
        console.log("Option invalid!");
        break;
    }
  };
  return (
    <div className="flex justify-center items-center w-screen h-screen">
      <div className="p-4">
        <form className="*:block" onSubmit={handleSubmit}>
          <label>User</label>
          <input
            name="user"
            type="text"
            placeholder="Username"
            onChange={handleOnChange}
          />
          <label>Password</label>
          <input
            name="password"
            type="password"
            placeholder="Password"
            onChange={handleOnChange}
          />
          <div className="my-2">
            <button
              type="submit"
              className="cursor-pointer bg-green-200 p-2 rounded text-black"
            >
              Submit
            </button>
          </div>
        </form>
      </div>
    </div>
  );
};
export default Page;
