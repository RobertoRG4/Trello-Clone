interface Props {
  id?: number;
  description: string;
  status: string;
}

const Task: React.FC<Props> = ({ id, description, status }) => {
  return (
    <div
      key={id}
      className="flex justify-between p-4 mt-2 rounded w-[400px] bg-gray-400 bold"
    >
      <p>{description}</p>
      <span>{status}</span>
    </div>
  );
};
export default Task;
