const usePostTask = () => {
  return async (descriptionTask: string, statusTask: string) => {
    const response = await fetch(
      `${process.env.NEXT_PUBLIC_API_URL}/api/task`,
      {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify({
          description: descriptionTask,
          status: statusTask,
        }),
      }
    );
    console.log(response);
  };
};
export default usePostTask;
