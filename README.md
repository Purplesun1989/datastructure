
# Data Structures in C++ (in_c branch) • 2022–2023

This branch collects my implementations of core data structures and algorithms in **C++**, developed during **2022–2023** as part of my learning journey.

## 📁 Files

- **GraphTopologicalsort.cpp**  
  Implements topological sort on a directed acyclic graph (using DFS).

- **breadthFirst.cpp**  
  Performs breadth-first traversal (BFS) on a graph.

- **ShellSort.cpp**  
  Shell sort algorithm for array of integers.

- **MergeSort.cpp**  
  Standard merge sort implementation.

- **PriorityQ.cpp**  
  A priority queue interface backed by a binary heap.

- **LeftistHeap.cpp**  
  Leftist (mergeable) heap supporting fast meld operations.

- **HashTableonLinkedlist.cpp**  
  Hash table with separate chaining via linked lists.

- **OpenHashing.cpp**  
  Hash table using open addressing (linear probing).

- **.gitignore**  
  Rules to ignore common build artifacts and editor/OS files.

## 🛠 Build & Run

1. **Clone this branch**  
   ```bash
   git clone --branch in_c \
     https://github.com/Purplesun1989/datastructure.git
   cd datastructure
````

2. **Compile all files**

   ```bash
   g++ *.cpp -std=c++17 -o ds_in_c
   ```

3. **Run**

   ```bash
   ./ds_in_c
   ```

*(Or compile individual files as needed, e.g. `g++ GraphTopologicalsort.cpp -o topo`.)*

## 📌 Notes

* All code is written for **educational purposes**; error-checking and edge-case handling are minimal.
* Each `.cpp` file is self-contained and can be compiled/executed independently.
* Feedback, corrections, or enhancements are welcome via Issues or Pull Requests.

---

*Branch:* `in_c` • *Timeline:* **2022–2023**
*Language:* C++ • *Compiler:* GCC or Clang

````

You can add this to your branch with:

```bash
git checkout in_c
echo "PASTE THE ABOVE CONTENT" > README.md
git add README.md
git commit -m "Add README for in_c branch (Data Structures in C++, 2022–2023)"
git push origin in_c
````


