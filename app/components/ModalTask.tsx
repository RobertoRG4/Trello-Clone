import { MdOutlineCancel } from "react-icons/md";

interface Props {
  handleCreateTask: (e: React.FormEvent<HTMLFormElement>) => void;
  handleOnClick: () => void;
  handleOnChange: (
    e: React.ChangeEvent<HTMLInputElement | HTMLSelectElement>
  ) => void;
}

const ModalTask: React.FC<Props> = ({
  handleCreateTask,
  handleOnClick,
  handleOnChange,
}) => {
  return (
    <div className="z-40 absolute flex justify-center items-center w-screen h-screen bg-black opacity-90">
      <div className="bg-sky-700 text-black p-10 rounded w-200">
        <div className="flex justify-end ">
          <button onClick={handleOnClick} className="cursor-pointer">
            <MdOutlineCancel size={25} color="#fff" />
          </button>
        </div>
        <form className="p-4 flex flex-col" onSubmit={handleCreateTask}>
          <label className="p-2 text-white font-bold">Description</label>
          <input
            name="description"
            className="p-2 text-white focus:outline-none"
            type="text"
            placeholder="Place here your description"
            onChange={handleOnChange}
          />
          <label className="p-2 text-white font-bold">Status</label>
          <select
            name="status"
            className="rounded p-2 text-white *:bg-gray-400 outline-none"
            defaultValue={"Select your status"}
            onChange={handleOnChange}
          >
            <option>Select your status</option>
            <option>Done</option>
            <option>Inprogress</option>
            <option>Init</option>
          </select>
          <div className="flex justify-end">
            <button className="rounded mt-3 p-2 px-5 bg-white" type="submit">
              Enviar
            </button>
          </div>
        </form>
      </div>
    </div>
  );
};
export default ModalTask;
