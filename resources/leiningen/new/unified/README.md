# Unified Template for {{name}} Project
## Prerequisites
- [Leiningen](https://leiningen.org): Tool for a peaceful Clojure(Script) environment.
- [PhantomJS](http://phantomjs.org): Javascript library for Unit Testing. Used for Frontend Unit Testing.

## Main commands
### Generic
- `lein clean`: clean the project

### Frontend
- `lein front`: Launch frontend in dev
- `lein test-front`: Launch frontend tests
- `lein build-front`: Launch frontend build

### Backend
- `lein back`: Launch backend in dev
- `lein test-back`: Launch backend tests

## Architecture
```
├── project.clj ---------------------->
├── README.md ------------------------>
├── resources
│   └── public
│       ├── cards.html --------------->
│       ├── css
│       │   └── style.css ------------>
│       └── index.html --------------->
├── src
│   ├── back
│   │   └── {{sanitized}}
│   │       └── core.clj ------------->
│   ├── common
│   │   └── {{sanitized}}
│   │       └── common
│   │           └── core.cljc -------->
│   └── front
│       └── {{sanitized}}
│           ├── core.cljs ------------>
│           └── core_devcards.cljs --->
└── test
    ├── back
    │   └── test
    │       └── core.clj ------------->
    ├── common
    │   └── test
    │       └── common
    │           └── core.cljc -------->
    └── front
        └── test
            ├── core.cljs ------------>
            └── runner.cljs ---------->
```
