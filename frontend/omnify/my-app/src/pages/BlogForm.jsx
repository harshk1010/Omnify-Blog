import React, { useState, useEffect } from "react";

function BlogForm({ onSave, editingPost }) {
  const [title, setTitle] = useState("");
  const [content, setContent] = useState("");

  useEffect(() => {
    if (editingPost) {
      setTitle(editingPost.title);
      setContent(editingPost.content);
    }
  }, [editingPost]);

  const handleSubmit = (e) => {
    e.preventDefault();
    if (!title || !content) return alert("Please fill all fields");
    onSave({ title, content });
    setTitle("");
    setContent("");
  };

  return (
    <form
      onSubmit={handleSubmit}
      className="bg-white/20 backdrop-blur-md p-6 rounded-2xl shadow-lg space-y-4"
    >
      <input
        type="text"
        placeholder="Title"
        className="w-full p-3 rounded-lg text-black"
        value={title}
        onChange={(e) => setTitle(e.target.value)}
      />
      <textarea
        placeholder="Content"
        className="w-full p-3 rounded-lg text-black"
        rows="4"
        value={content}
        onChange={(e) => setContent(e.target.value)}
      />
      <button
        type="submit"
        className="w-full bg-purple-600 hover:bg-purple-700 text-white py-2 rounded-lg"
      >
        {editingPost ? "Update Post" : "Add Post"}
      </button>
    </form>
  );
}

export default BlogForm;
